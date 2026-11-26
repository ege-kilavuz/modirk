#requires -Version 5.1
<#
    Races (modirk) gelistirme betigi.

    Kullanim:
        .\build.ps1                 # derle
        .\build.ps1 runClient       # istemciyi ac
        .\build.ps1 clean build     # temizle ve derle

    Betik, JAVA_HOME JDK 21 degilse sistemdeki JDK 21 kurulumlarini arar.
#>
param(
    [Parameter(ValueFromRemainingArguments = $true)]
    [string[]] $GradleArgs
)

$ErrorActionPreference = 'Stop'
$root = Split-Path -Parent $MyInvocation.MyCommand.Path
Push-Location $root
try {
    function Test-Jdk21([string] $home) {
        if ([string]::IsNullOrWhiteSpace($home)) { return $false }
        $javac = Join-Path $home 'bin\javac.exe'
        if (-not (Test-Path $javac)) { return $false }
        $version = & $javac -version 2>&1
        return ($version -match '^javac 21\.')
    }

    $jdk = $env:JAVA_HOME
    if (-not (Test-Jdk21 $jdk)) {
        $roots = @(
            'C:\Program Files\Java',
            'C:\Program Files\Eclipse Adoptium',
            'C:\Program Files\Amazon Corretto',
            'C:\Program Files\Microsoft'
        )
        $candidates = foreach ($r in $roots) {
            if (Test-Path $r) {
                Get-ChildItem $r -Directory -ErrorAction SilentlyContinue | Where-Object { $_.Name -match '21' }
            }
        }
        $found = $candidates | Where-Object { Test-Jdk21 $_.FullName } | Select-Object -First 1
        if (-not $found) {
            Write-Error "JDK 21 bulunamadi. https://adoptium.net/temurin/releases/?version=21 adresinden JDK 21 kurun veya JAVA_HOME degiskenini JDK 21'e ayarlayin."
            exit 1
        }
        $jdk = $found.FullName
    }

    $env:JAVA_HOME = $jdk
    $env:Path = "$jdk\bin;$env:Path"
    Write-Host "JDK: $jdk" -ForegroundColor DarkGray

    if (-not $GradleArgs -or $GradleArgs.Count -eq 0) {
        $GradleArgs = @('build')
    }

    & "$root\gradlew.bat" @GradleArgs
    exit $LASTEXITCODE
}
finally {
    Pop-Location
}
