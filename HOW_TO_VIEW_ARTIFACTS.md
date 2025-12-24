# How to View Artifacts (Coverage Reports) from GitHub Actions

This guide shows you step-by-step how to access and download coverage reports and other artifacts from GitHub Actions.

---

## Step-by-Step Instructions

### Step 1: Go to Your Repository

1. Open your web browser
2. Go to: **https://github.com/Sumeytm/Pomodoro-Timer**
3. You should see your repository page

### Step 2: Open Actions Tab

1. Click on the **"Actions"** tab at the top of the repository page
   - It's located next to "Code", "Issues", "Pull requests", etc.
2. You'll see a list of workflow runs

### Step 3: Select a Workflow Run

1. Find the **latest workflow run** (should be at the top)
2. Look for a run with a **green checkmark** ✅ (successful) or **yellow circle** ⏳ (in progress)
3. Click on the workflow run name (e.g., "Java CI/CD Pipeline")

### Step 4: View Workflow Details

1. You'll see all the steps of the workflow
2. Scroll down to see all steps:
   - ✅ Checkout code
   - ✅ Build with Maven
   - ✅ Run tests
   - ✅ Generate coverage report
   - etc.

### Step 5: Find Artifacts Section

1. **Scroll to the very bottom** of the workflow run page
2. Look for a section called **"Artifacts"**
   - It's usually at the bottom, after all the workflow steps
   - You'll see boxes with artifact names

### Step 6: Download Artifacts

You should see two artifacts:

1. **coverage-reports**
   - Contains JaCoCo coverage reports (HTML and XML)
   - Click on it to download

2. **javadoc**
   - Contains Javadoc documentation (HTML and PDF)
   - Click on it to download

### Step 7: Extract and View

1. **Download the artifact:**
   - Click on "coverage-reports"
   - A ZIP file will download

2. **Extract the ZIP file:**
   - Right-click on the downloaded ZIP file
   - Select "Extract All" or use a tool like WinRAR/7-Zip
   - Choose a location to extract

3. **Navigate to the HTML report:**
   - Open the extracted folder
   - Go to: `pomodorotimertimertimer-app/target/site/jacoco/`
   - Find `index.html` file

4. **Open the report:**
   - Double-click `index.html`
   - It will open in your default web browser
   - You'll see a colorful coverage report!

---

## Visual Guide

```
GitHub Repository
    ↓
[Actions] Tab ← Click here
    ↓
Workflow Runs List
    ↓
Click on latest run
    ↓
Scroll to bottom
    ↓
[Artifacts] Section ← Find here
    ↓
Click "coverage-reports"
    ↓
Download ZIP
    ↓
Extract ZIP
    ↓
Open index.html
```

---

## What You'll See in the Coverage Report

When you open `index.html`, you'll see:

1. **Summary Table:**
   - Total coverage percentage
   - Line coverage
   - Branch coverage
   - Method coverage
   - Class coverage

2. **Package List:**
   - All packages in your project
   - Coverage percentage for each

3. **Class Details:**
   - Click on a class name to see:
     - Which lines are covered (green)
     - Which lines are not covered (red)
     - Which branches are tested
     - Which methods are tested

4. **Color Coding:**
   - 🟢 **Green**: Covered (tested)
   - 🔴 **Red**: Not covered (needs tests)
   - 🟡 **Yellow**: Partially covered

---

## Alternative: View Artifacts Directly

If you can't find artifacts at the bottom:

1. Look for a **"Summary"** section in the workflow run
2. Artifacts might be listed there
3. Or check the workflow run page for a **"Artifacts"** button/link

---

## Troubleshooting

### Problem: No Artifacts Visible

**Solution:**
- Make sure the workflow run completed successfully
- Artifacts are only created if the workflow runs to completion
- Check if the "Upload coverage reports" step succeeded

### Problem: Artifacts Section Not Showing

**Solution:**
- Wait a few minutes - artifacts are uploaded after workflow completes
- Refresh the page
- Check if the upload steps succeeded (green checkmarks)

### Problem: Can't Download Artifacts

**Solution:**
- Make sure you're logged into GitHub
- Try a different browser
- Check your internet connection

---

## Quick Access Link

Direct link to your Actions page:
**https://github.com/Sumeytm/Pomodoro-Timer/actions**

---

## Tips

1. **Always download the latest run** for up-to-date coverage
2. **Keep artifacts** - they're useful for your final report
3. **Take screenshots** of the coverage report for your presentation
4. **Compare coverage** between different runs to see improvements

---

## Next Steps After Viewing Coverage

1. **Identify low coverage classes** (red/yellow in the report)
2. **Add missing tests** for those classes
3. **Re-run the workflow** to see improved coverage
4. **Repeat until 100% coverage** (if required)

Good luck! 🎉

