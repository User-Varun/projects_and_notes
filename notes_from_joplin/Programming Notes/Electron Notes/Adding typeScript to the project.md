**\# adding in  `tsconfig.json` in electron folder**

```json
{

"compilerOptions": {

// require strict types ( null-save)

"strict": true,

// tell typeScript to generate ESM Syntax

"target": "ESNext",

// tell typeScript to require ESM Syntax as input ( including .js file imports)

"module": "NodeNext",

// define where to put generated JS

"outDir": "../../dist-electron",

// ignore errors from dependencies

"skipLibCheck": true

}

}
```

# **Adding in package.json our script for electron**

`"transpile:electron" : "tsc --project src/electron/tsconfig.json"`

&nbsp;

**changing `main` command in package.json**

`"main": "dist-electron/main.js"`

**Excluding the dist-electron from our git ( inside .gitignore )**

`dist-electron`

&nbsp;