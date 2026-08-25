**installing electron builder** 

`npm i --save-dev electron-builder`

##  **adding electron-builder.json**

`{`

`"appId": "com.company.electron-crash-course",`

`"files": ["dist-electron", "dist-react"],`

`"icon": "./icon.png",`

`"mac": {`

`"target": "dmg"`

`},`

`"linux": {`

`"target": "AppImage",`

`"category": "Utility"`

`},`

`"win": {`

`"target": ["portable", "msi"]`

`}`

`}`

## changes in package.json for mac, Linux , windows (in scripts )

`"dist:mac": "npm run transpile:electron && npm run build && electron-builder --mac --arm64",`

`"dist:win": "npm run transpile:electron && npm run build && electron-builder --win --x64",`

`"dist:linux": "npm run transpile:electron && npm run build && electron-builder --linux --x64"`

## Turning on developer mode in windows setting ( to give permission )

&nbsp;

&nbsp;