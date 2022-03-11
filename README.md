# Code Conventions Automation for `OneApp`
The information on this page is for Archive Purposes Only

This page is not being actively maintained. Links within the documentation may not work and the information itself may no longer be valid. The last revision to this document was made on April 20, 1999

### Naming Conventions
Naming conventions make programs more understandable by making them easier to read. They can also give information about the function of the identifier-for example, whether it's a constant, package, or class-which can be helpful in understanding the code.

| Identifier Type | Rules for Naming | Examples |
|:---------------:|:-----------------|:---------|
|Packages|The prefix of a unique package name is always written in all-lowercase ASCII letters and should be one of the top-level domain names, currently com, edu, gov, mil, net, org, or one of the English two-letter codes identifying countries as specified in ISO Standard 3166, 1981. Subsequent components of the package name vary according to an organization's own internal naming conventions. Such conventions might specify that certain directory name components be division, department, project, machine, or login names.| com.sun.eng com.apple.quicktime.v2 edu.cmu.cs.bovik.cheese|
|Classes|Class names should be nouns, in mixed case with the first letter of each internal word capitalized. Try to keep your class names simple and descriptive. Use whole words-avoid acronyms and abbreviations (unless the abbreviation is much more widely used than the long form, such as URL or HTML).|class Raster; <br>class ImageSprite;|
|Interfaces|Interface names should be capitalized like class names.|interface RasterDelegate; <br>interface Storing;|
|Methods|Methods should be verbs, in mixed case with the first letter lowercase, with the first letter of each internal word capitalized.|run();<br>runFast(); <br>getBackground();|
|Variables|Except for variables, all instance, class, and class constants are in mixed case with a lowercase first letter. Internal words start with capital letters. Variable names should not start with underscore _ or dollar sign $ characters, even though both are allowed.Variable names should be short yet meaningful. The choice of a variable name should be mnemonic- that is, designed to indicate to the casual observer the intent of its use. One-character variable names should be avoided except for temporary "throwaway" variables. Common names for temporary variables are i, j, k, m, and n for integers; c, d, and e for characters.|int i;<br>char c; <br>float myWidth;|
|Constants|The names of variables declared class constants and of ANSI constants should be all uppercase with words separated by underscores ("_"). (ANSI constants should be avoided, for ease of debugging.)|static final int MIN_WIDTH = 4;<br>static final int MAX_WIDTH = 999; <br>static final int GET_THE_CPU = 1; static final int INVERTMENT_LOGIN_MAX = 1;<br> static final String CUSTOMER_SERVICE_LOGIN_MIN = "3";|
|Element ID| The names of variables declared class constants and of ANSI constants should be all uppercase with words separated by underscores ("_"). (ANSI constants should be avoided, for ease of debugging. Ex: squad SQUAD_NAME_XXX_XXX_TYPE <br> Label = SQUAD_NAME_XXX_XXX_LABEL <br>Button = SQUAD_NAME_XXX_XXX_BUTTON <br> Text = SQUAD_NAME_XXX_XXX_TEXT <br> RadioButton = SQUAD_NAME_XXX_XXX_RADIO_BUTTON <br> CheckBox = SQUAD_NAME_XXX_XXX_CHECK_BOX <br> Loading = SQUAD_NAME_XXX_XXX_LOADING <br> ProgressView = SQUAD_NAME_XXX_XXX_PROGRESS_VIEW <br> TableView = SQUAD_NAME_XXX_XXX_TABLE_VIEW <br> TableCell = SQUAD_NAME_XXX_XXX_TABLE_CELL <br> Image = SQUAD_NAME_XXX_XXX_IMAGE <br> CollectionView = SQUAD_NAME_XXX_XXX_COLLECTION_VIEW <br> CollectionCell = SQUAD_NAME_XXX_XXX_COLLECTION_CELL <br> PageControl = SQUAD_NAME_XXX_XXX_PAGE_CONTROL <br> Tab = SQUAD_NAME_XXX_XXX_TAB <br> ScrollView = SQUAD_NAME_XXX_XXX_SCROLL_VIEW <br> DatePicker = SQUAD_NAME_XXX_XXX_DATE_PICKER <br> PickerView = SQUAD_NAME_XXX_XXX_PICKER_VIEW <br> MapView = SQUAD_NAME_XXX_XXX_MAP_VIEW <br> WebView = SQUAD_NAME_XXX_XXX_WEB_VIEW <br> NavigationBar = SQUAD_NAME_XXX_XXX_NAVIGATION_BAR <br> NavigationItem = SQUAD_NAME_XXX_XXX_NAVIGATION_ITEM)|AUTOLON_LOGIN_BUTTON<br>INVESMENT_USER_NAME_TEXT<br>CUSTOMER_SERVICE_PASSWORD_TEXT<br>LENDING_SEN_EMAIL_CHECKBOX<br> PRIMARY_BANKING_1_LOGIN_BUTTON<br>PRIMARY_BANKING_2_LOGIN_BUTTON|

###  File Names

This section lists commonly used file suffixes and names.



- File Suffixes
    - Java Software uses the following file suffixes:

| File Type | Suffix | 
|:---------------:|:-----------------|
|Java source|.java|
|Java bytecode|.class|

- Common File Names
    - Frequently used file names include

| File Name | Use |
|:---------------:|:-----------------|
|GNUmakefile|The preferred name for makefiles. We use gnumake to build our software.|
|README|The preferred name for the file that summarizes the contents of a particular directory.|

## Structure in project
- src
    - main
        - java
            - framework
                - DiverFactory
                - DeviceProfile
                - TmbTestContext
                - OneAppElements
                - AndroidOneAppElements
                    - Editable
                - iOSOneAppElements
                    - Editable
                - OneAppElementsKeys
                    - Editable
                - BaseScenario
        - resources
            - document
            - driver
            - fonts
            - autoloan
            - customerservice
            - investment
            - lending
            - primarybanking1
            - primarybanking2
        - test
            - java
                - runner
                    - autoloan
                    - customerservice
                    - investment
                    - lending
                    - primarybanking1
                    - primarybanking2
                - scenario
                    - autoloan
                    - customerservice
                    - investment
                    - lending
                    - primarybanking1
                    - primarybanking2

- target
- test-output
- .gitignore
    - /target/
    - /test-output/
    - /app.log
    - .idea
    - .settings
    - .project
    - /reports
    - automation-testing.iml
- pom.xml
- README.md


# Step Open PR
- [1] Format code `(Win:control+Alt+L Mac: command+L)`
- [2] Commit code
- [3] Push code
- [4] Open PR
    - Current branch to Develop branch
    - Assign to reviewer
        - TCS (`Vendor245, Vendor264, Vendor334`)