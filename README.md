# Ghidra FindCrypt

![Bug eyed Ghidra looks at complex algorithms](docs/findcrypt_logo.png)

[![Build](https://github.com/antoniovazquezblanco/GhidraFindcrypt/actions/workflows/main.yml/badge.svg)](https://github.com/antoniovazquezblanco/GhidraFindcrypt/actions/workflows/main.yml)

This is a fork of another [Ghidra FindCrypt](https://github.com/TorgoTorgo/ghidra-findcrypt) that is a re-write of another [Ghidra FindCrypt](https://github.com/d3v1l401/FindCrypt-Ghidra/) script as an auto analysis module. It also takes better advantage of the Ghidra API to label found constants.


## Installing

Go to the [releases page](https://github.com/antoniovazquezblanco/GhidraFindcrypt/releases) and download the latest version for your Ghidra distribution.

In Ghidra main window go to `File` > `Install extensions...`. In the new window press the `+` icon to import the downloaded zip.


## Using

Once the script is installed, a new Analysis is added to the Auto Analyze window called "Find Crypt", it's enabled by default and it's safe to re-run.
If you have an existing file, open the "Analysis" menu in the CodeBrowser tool and click "Auto Analyze".
Select the "Find Crypt" analysis from the list and click Analyze.

Once the analysis is complete, any found crypt constants will be labeled with the algorithm they're associated with.
You can find these labels in the "Labels" folder in the Symbol Tree window.
The labels are prefixed with `CRYPT_` to group them together.

The analysis will also try to set the datatype for the found constants, but if a datatype has been applied by another analysis module that other module will take precedence.

A comment is always placed when a crypt constant is found to tell you the type and the size of the constant, just in case the datatype wasn't applied.


## Development

### Development environment

1. First, install [Eclipse for Java Developers](https://www.eclipse.org/downloads/packages/).
2. Once installed, open Eclipse and click on `Help` > `Install New Software...`. A window will pop up.
3. Click on `Add...` > `Archive...`. It will open a file selection dialog. In this dialog, please select `GhidraDev.zip` file from `<Your Ghidra install dir>/Extensions/Eclipse/GhidraDev/`.
4. Check Ghidra category (or GhidraDev entry).
5. Repeatedly click `Next`.
6. Accept the terms of the license agreement.
7. Check the `Unsigned` table entry and click `Trust Selected`.
8. Restart Eclipse...

### Importing the project

After all of that, if you still want to develop and/or contribute to the project, first clone this repository:
```bash
git clone git@github.com:antoniovazquezblanco/GhidraFindcrypt.git
```

In Eclipse:
1. Click on `File` > `Import...`.
2. In the dialog click on `General` > `Projects from Folder or Archive` > `Next`.
3. Click on `Directory...` and select the `GhidraFindcrypt` folder you have just cloned.
4. Click on `Finish`.
5. Right click on the just imported project `GhidraDev` > `Link Ghidra...`.
6. Select your desired Ghidra installation and click on `Finish`.

You are now ready to develop!
