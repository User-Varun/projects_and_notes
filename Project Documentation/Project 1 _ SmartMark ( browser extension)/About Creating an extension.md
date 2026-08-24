## 🧠 What You Need to Know Before Making a Browser Extension

### 🧩 1. **What Is a Browser Extension?**

A browser extension is a small software that “extends” the functionality of a browser. Think of them as **mini web apps** that:

- Run inside your browser
    
- Interact with websites (DOM, scroll, cookies)
    
- Provide extra features (notes, tools, shortcuts, etc.)
    

They are made up of:

| Part | Purpose |
| --- | --- |
| `manifest.json` | Declares extension details (name, permissions, scripts) |
| `popup.html/js` | Shown when you click the extension icon (like a mini UI) |
| `content scripts` | Runs **inside webpages**, lets you access and manipulate them |
| `background script` | Runs persistently in the background (e.g., for sync, timers) |

### 🔐 2. **Permissions and Manifest v3**

You define your extension’s capabilities in `manifest.json`. This is where you specify:

- What URLs you can access
    
- What APIs you need (`storage`, `tabs`, `scripting`, etc.)
    
- What scripts get injected into web pages
    

Since **Manifest V3** is now standard (used by Chrome/Brave), your extension must follow its stricter rules:

- Background script must be a **service worker**
    
- Uses **`chrome.scripting`** to inject code dynamically
    

```json
"permissions": [
  "storage", "activeTab", "tabs", "scripting"
],
"host_permissions": [
  "<all_urls>"
]

```

### 🧱 3. **Core Concepts You'll Use**

| Concept | Description |
| --- | --- |
| `chrome.storage` | Save/load data (like bookmarks or scroll positions) |
| `chrome.tabs` | Interact with open browser tabs |
| `chrome.scripting` | Inject code into a tab's page (for scrolling, grabbing data) |
| `content script` | Code injected into websites to read DOM or control scroll |
| `popup.html/js` | A mini React app shown when the user clicks the extension icon |

* * *

### 🧪 4. **How You Build & Load the Extension**

Brave has a developer mode just like Chrome.

**Steps:**

1.  Go to `brave://extensions`
    
2.  Enable **Developer Mode** (top right)
    
3.  Click **“Load unpacked”**
    
4.  Select the folder containing your extension
    

Now when you update your code, click **“Reload”** on that extension to apply changes.

* * *

### ⚠️ 5. **Things to Watch Out For**

| Issue | Why It Matters | How to Handle |
| --- | --- | --- |
| CSP (Content Security Policy) | Some websites block your scripts | Test on friendly websites first |
| Manifest version | v3 is stricter, background service workers sleep | Always use `chrome.runtime.onMessage` or triggers |
| Injection timing | DOM may not be ready | Use `run_at: "document_idle"` or `DOMContentLoaded` |
| Async logic | Many Chrome APIs are callback-based | Use `async/await` wrappers or Promisify |