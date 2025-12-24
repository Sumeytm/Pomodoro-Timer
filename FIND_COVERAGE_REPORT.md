# How to Find the Coverage Report (index.html)

If you can't find `index.html`, follow these steps to locate it.

---

## Step 1: Extract the ZIP File

1. **Download the artifact** from GitHub Actions (coverage-reports)
2. **Right-click** on the downloaded ZIP file
3. **Extract All** or use WinRAR/7-Zip
4. **Remember where you extracted it** (e.g., Desktop, Downloads folder)

---

## Step 2: Navigate Through Folders

The file structure inside the ZIP might be different. Try these paths:

### Option A: Standard Path
```
extracted-folder/
└── pomodorotimertimertimer-app/
    └── target/
        └── site/
            └── jacoco/
                └── index.html  ← HERE!
```

### Option B: Alternative Path
```
extracted-folder/
└── target/
    └── site/
        └── jacoco/
            └── index.html  ← HERE!
```

### Option C: Direct Path
```
extracted-folder/
└── jacoco/
    └── index.html  ← HERE!
```

---

## Step 3: Search for the File

If you still can't find it:

1. **Open the extracted folder** in Windows File Explorer
2. **Click in the search box** (top right of File Explorer)
3. **Type:** `index.html`
4. **Press Enter**
5. Windows will search for the file in all subfolders

---

## Step 4: Alternative - Check All HTML Files

1. In the extracted folder, **search for:** `*.html`
2. You might find:
   - `index.html` (main report)
   - Other HTML files (these are part of the report)

---

## Step 5: If Still Not Found

The coverage report might not have been generated. Check:

1. **Go back to GitHub Actions**
2. **Check the workflow run:**
   - Did "Generate JaCoCo coverage report" step succeed? ✅
   - Did "Upload coverage reports" step succeed? ✅
3. **If steps failed:**
   - The report wasn't generated
   - You need to fix the workflow or wait for a successful run

---

## Alternative: Generate Coverage Locally

If you have Maven installed, generate the report locally:

1. **Open PowerShell or Command Prompt**
2. **Navigate to project:**
   ```bash
   cd C:\Users\pc\Pomodoro-Timer\pomodorotimertimertimer-app
   ```

3. **Run Maven commands:**
   ```bash
   mvn clean test jacoco:report
   ```

4. **Find the report:**
   - Go to: `target/site/jacoco/index.html`
   - Full path: `C:\Users\pc\Pomodoro-Timer\pomodorotimertimertimer-app\target\site\jacoco\index.html`

---

## Visual Guide: Finding the File

```
Downloaded ZIP: coverage-reports.zip
    ↓
Extract to: C:\Users\pc\Downloads\coverage-reports\
    ↓
Open folder in File Explorer
    ↓
Look for folders: pomodorotimertimertimer-app → target → site → jacoco
    ↓
OR use Search: type "index.html"
    ↓
Double-click index.html
```

---

## Quick Check: What Files Should Be in the ZIP?

The coverage-reports artifact should contain:
- `index.html` (main report)
- `jacoco.xml` (XML report)
- `jacoco.csv` (CSV report)
- Other HTML/CSS/JS files (for the report display)

If you see these files, you're in the right place!

---

## Still Having Issues?

1. **Take a screenshot** of the extracted folder structure
2. **Check the GitHub Actions logs** to see if the report was generated
3. **Try generating locally** using Maven (see Step 5 above)

Let me know what you find!

