#!/bin/bash
PACKAGE_PATH="$1"

OUTPUT_FILE="$PACKAGE_PATH/test/tester.java"
mkdir -p "$PACKAGE_PATH/test"

find "$PACKAGE_PATH" -name "*.java" -exec sed -n '/^import /p' {} + > "$OUTPUT_FILE"
find "$PACKAGE_PATH" -name "*.java" -exec sed -e '/^package/d' -e '/^import/d' -e '/^$/d' {} + >> "$OUTPUT_FILE"
echo "" >> "$OUTPUT_FILE"

echo "All Java files in $PACKAGE_PATH have been concatenated into $OUTPUT_FILE"
