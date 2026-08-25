`npm i --save-dev cross-env` installing this dev dependency 

`"dev:electron": "cross-env NODE_ENV=development electron .",` setting in package.json 

## inside electron folder create util.ts

`import { defineConfig } from "vite";`

`import react from "@vitejs/plugin-react";`

`export function isDev(): boolean {`

`return process.env.NODE_ENV === "development";`

`}`

`export default defineConfig({`

`plugins: [react()],`

`base: "./", // Ensure relative paths for assets`

`build: {`

`outDir: "dist-react",`

`},`

`server: {`

`port: 5200, // Port for development server`

`strictPort: true, // Ensure the port is not changed`

`},`

`});`

## inside main.ts

`if (isDev()) {`

`mainWindow.loadURL("http://localhost:5200");`

`} else {`

`mainWindow.loadFile(path.join(app.getAppPath(), "/dist-react/index.html"));`

`}`

&nbsp;

## **in `vite.config.ts`**

`server: {`

`port: 5200,`

`},`

&nbsp;

## **with these configurations our hot module replacement is setup so don't need any unnecessary  server restarts**

## **now configuration for running multiple scripts in parallel so not need to open two terminal** 

**install `npm i --save-dev npm-run-all` package**

## **edit in package.json**

`"dev:electron": "npm run transpile:electron && cross-env NODE_ENV=development electron .",`

`"dev": "npm-run-all --parallel dev:react dev:electron",`

&nbsp;