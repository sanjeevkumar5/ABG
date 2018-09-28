# ABG
ABG_New_GUI

Goal:

To clone this repo and test ARC application with automated tests

What technologies is needed:

    1.NodeJS and NPM
    2.CNTLM setup for the current user
    3.Git setup in the PC to clone the repo
    4.BCI client to be installed from software center

Refer the below confluence URL to set Node,NPM,CNTLM and GIT

    https://confluence.bc/display/IC/2.0.+New+Welcome+Pack#id-2.0.NewWelcomePack-Environment

Important:

    NodeJS version 9.5.0
    NPM version 6.1.0

Please update Node and NPM to the versions mentioned above.


Steps to set up the project

1.Clone the Project from Git

    git clone https://github.com/sanjeevkumar5/ABG.git
   
2.CD to the folder and run the command in cmd Prompt this will download all requird packages from npm.org
    
    npm i

3.Install these two packages from NPM globally using the command
    
    npm i -g gulp
    
    npm i -g gulp-cli

4.Copy the ARC latest build and extract in the project directory 

![alt text](Capture.png "Description goes here")

5.Change the callback endpoint URL in the directory test\pages\Calling_pages\callback.js

![alt text](Capture2.PNG "Description goes here")

7.To start the execution 

    gulp ARC
    
8.Refer the mochawesome-reports folder for HTML report after execution
