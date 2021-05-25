# Templates
Code generation and export tool

## Getting Started
1. Write the template and place it in the ./resources folder
2. Write the parameter.properties file
3. Update and run Main-Class: com.lyrieek.templates.Export

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

3. Replace the `com.lyrieek.templates.Export` `moduleFolder` constant with `simpleTest`, when you run it, you get a file
    - `resources/simpleTest/parameter.properties`
    ```txt
    test=
    ```

4. Change the value of test to any value, For example `test=foo`

5. Run `com.lyrieek.templates.Export` again, get results
- `resources/simpleTest/test.txt`
```txt
var foo = 'Hello templates'
console.log(foo)
```

## Properties configuration

### `parameter.properties`
- `file.common.prefix` output file starts with this by default
- `file.common.ext` default file extension
- `file.builtIn.ext` extension are already built in and do not need to be added

## Parametric decoration function
Under normal conditions, you need to avoid “.” in parameter, because using it means you're going to call some decorator function, these methods are listed below

| Function name | Description | Example | Example result |
| :--- | --- | --- | --- |
| .upper | upper case | \\{v.upper}, v=abC | ABC |
| .lower | lower case | \\{v.lower}, v=AbC | abc |
| .camel | camel nomenclature | \\{v.camel}, v=sweet bean | sweetBean |
| .pascal | pascal nomenclature | \\{v.pascal}, v=sweet bean | SweetBean |
| .hungarian | Hungarian nomenclature | \\{v.hungarian}, v=sweet bean | sweet_bean |
| .natural | natural language | \\{v.natural}, v=SweetBean | sweet bean |

## Contributing
Apache-2.0

