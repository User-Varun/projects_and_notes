`npm install --save-dev electron` to install a electron as dev dependency.

`npm create vite .` create boiler place code for vite app

`npm install` for install necessary dependencies.

using `base : "./"` for ensuring relative paths for assets

configure `build : { outDir : "dist-react" }` for storing the build of react , so it's identifiable from others like build from electron

the main settings represents the entry point of the app in this electron app we used `"main": "src/electron/main.js`