# `script.sh`

This shell script is designed to perform a specific task related to Java files in a given package. It can be used to concatenate the content of multiple Java files into a single file while excluding the package declaration and import statements.

## Usage

To use the script, follow the instructions below:

1. **Provide Package Name as Parameter:**
   ```bash
   ./script.sh <package_name>
   ```

   Replace `<package_name>` with the actual Java package name you want to process.

2. **Output:**
    - The script will create a file named `buildFileFinki.java` in the current directory.
    - This file will contain the concatenated content of all Java files within the specified package and its subdirectories.

## Example

```bash
./script.sh src/labs/lab11/roads
```

This command will concatenate the content of all Java files in the package added in the command line as argument, excluding package declarations and import statements, and store the result in a file named `AllJavaFiles.java`.

Which further can be used to uploaded as solution in finki code runner 
