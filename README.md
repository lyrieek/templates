# Templates
Code generation and export tool

## Getting Started
1. Write the template and place it in the ./resources folder
2. Write the parameter.properties file
3. Update and run Main-Class: com.lyrieek.Export

## Use case
1. Create `simpleTest` new folder called `simpleTest` in your resources, it's like using a command like this
    ```bash
    cd resources
    mkdir simpleTest
    ```

2. Write a file called `test.template` in `simpleTest`
    - `resources/simpleTest/test.template`
    ```txt
    var \{test} = 'Hello templates'
    console.log(\{test})
    ```

3. Replace the `com.lyrieek.Export` `moduleFolder` constant with `simpleTest`, when you run it, you get a file
    - `resources/simpleTest/parameter.properties`
    ```txt
    test=
    ```

4. Change the value of test to any value, For example `test=foo`

5. Run `com.lyrieek.Export` again, get results
- `resources/simpleTest/test.txt`
```txt
var foo = 'Hello templates'
console.log(foo)
```

## Contributing
Apache-2.0

