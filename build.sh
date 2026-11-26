#!/usr/bin/env bash
# Races (modirk) gelistirme betigi.
#
# Kullanim:
#   ./build.sh                 # derle
#   ./build.sh runClient       # istemciyi ac
#   ./build.sh clean build     # temizle ve derle
#
# Betik, JAVA_HOME JDK 21 degilse yaygin kurulum yerlerinde JDK 21 arar.

set -euo pipefail
cd "$(dirname "$0")"

is_jdk21() {
    local home="${1:-}"
    [ -n "$home" ] && [ -x "$home/bin/javac" ] && "$home/bin/javac" -version 2>&1 | grep -q '^javac 21\.'
}

if ! is_jdk21 "${JAVA_HOME:-}"; then
    for candidate in \
        /usr/lib/jvm/*21* \
        /usr/java/*21* \
        /opt/*21* \
        "$HOME/.sdkman/candidates/java/"*21* \
        "/Library/Java/JavaVirtualMachines/"*21*/Contents/Home; do
        if is_jdk21 "$candidate"; then
            export JAVA_HOME="$candidate"
            break
        fi
    done
fi

if ! is_jdk21 "${JAVA_HOME:-}"; then
    echo "JDK 21 bulunamadi. https://adoptium.net/temurin/releases/?version=21 adresinden JDK 21 kurun veya JAVA_HOME degiskenini JDK 21'e ayarlayin." >&2
    exit 1
fi

export PATH="$JAVA_HOME/bin:$PATH"
echo "JDK: $JAVA_HOME"

if [ "$#" -eq 0 ]; then
    set -- build
fi

exec ./gradlew "$@"
