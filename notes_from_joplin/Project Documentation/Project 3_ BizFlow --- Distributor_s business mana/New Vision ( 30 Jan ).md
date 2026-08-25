- Building BizFlow as an standalone desktop application
- made using Electron.js and Backend built on Node.js

## Folder Structure

```js
bizflow/
│
├─ package.json
├─ tsconfig.json
├─ electron-builder.json (optional)
│
├─ src/
│   ├─ main/                 # Electron Main Process (Node Backend)
│   │   ├─ main.ts
│   │   ├─ windows/
│   │   │   └─ mainWindow.ts
│   │   ├─ ipc/
│   │   │   ├─ product.ipc.ts
│   │   │   ├─ invoice.ipc.ts
│   │   │   └─ index.ts
│   │   ├─ services/
│   │   │   ├─ db.service.ts
│   │   │   ├─ file.service.ts
│   │   │   └─ print.service.ts
│   │   └─ utils/
│   │       └─ logger.ts
│   │
│   ├─ preload/
│   │   └─ preload.ts        # Secure bridge
│   │
│   ├─ renderer/             # Frontend (React/Vite)
│   │   ├─ index.html
│   │   ├─ main.tsx
│   │   ├─ pages/
│   │   ├─ components/
│   │   ├─ hooks/
│   │   ├─ store/
│   │   └─ styles/
│   │
│   ├─ shared/               # Shared Types + Constants
│   │   ├─ types/
│   │   │   ├─ product.ts
│   │   │   └─ invoice.ts
│   │   ├─ channels.ts       # IPC channel names
│   │   └─ constants.ts
│   │
│   └─ database/
│       ├─ schema.ts
│       └─ migrations/
│
├─ dist/                      # Build Output
└─ assets/

```

&nbsp;