# Ghidra FindCrypt

![Bug eyed Ghidra looks at complex algorithms](docs/findcrypt_logo.png)

[![Build](https://github.com/antoniovazquezblanco/ghidra-findcrypt/actions/workflows/main.yml/badge.svg)](https://github.com/antoniovazquezblanco/ghidra-findcrypt/actions/workflows/main.yml)

This is a fork of another [Ghidra FindCrypt](https://github.com/TorgoTorgo/ghidra-findcrypt) that is a re-write of another [Ghidra FindCrypt](https://github.com/d3v1l401/FindCrypt-Ghidra/) script as an auto analysis module. It also takes better advantage of the Ghidra API to label found constants.


## Installing

Go to the [releases page](https://github.com/antoniovazquezblanco/ghidra-findcrypt/releases) and download the latest version for your Ghidra distribution.

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
