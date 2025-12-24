# How to Use the Coverage Report

Now that you have the coverage report open, here's what to do with it.

---

## Step 1: Understand What You're Looking At

### Main Summary Table
At the top, you'll see:
- **Total Coverage**: Overall percentage (e.g., 85%)
- **Line Coverage**: How many lines are tested
- **Branch Coverage**: How many if/else branches are tested
- **Method Coverage**: How many methods are tested
- **Class Coverage**: How many classes are tested

### Color Coding
- 🟢 **Green**: Covered (tested) - Good!
- 🔴 **Red**: Not covered (needs tests) - Bad!
- 🟡 **Yellow**: Partially covered - Needs more tests

---

## Step 2: Identify Classes with Low Coverage

1. **Scroll down** to see the package list
2. **Look for red or yellow classes** (low coverage)
3. **Click on a class name** to see details

### What to Look For:
- Classes with **less than 100% coverage** (red/yellow)
- Classes with **0% coverage** (completely red)
- Classes with **missing branches** (if/else not tested)

---

## Step 3: Analyze Each Low-Coverage Class

When you click on a class:

1. **See which lines are red** (not tested)
2. **See which branches are red** (if/else not tested)
3. **Identify what's missing:**
   - Which methods need tests?
   - Which edge cases are missing?
   - Which error conditions aren't tested?

### Example:
If you see:
- Line 45: Red (not covered)
- Line 67: Red (not covered)
- Branch at line 50: Red (else case not tested)

You need to add tests for:
- The code at line 45
- The code at line 67
- The else branch at line 50

---

## Step 4: Add Missing Tests

For each red/yellow class:

1. **Open the corresponding test file**
   - Example: `DoubleLinkedList.java` → `DoubleLinkedListTest.java`

2. **Add new test methods** for missing coverage:
   ```java
   @Test
   public void testMissingScenario() {
       // Test the code that's not covered
       // This should cover the red lines
   }
   ```

3. **Test edge cases:**
   - Empty collections
   - Null values
   - Boundary conditions
   - Error conditions

4. **Test all branches:**
   - Both if and else cases
   - All switch cases
   - All loop conditions

---

## Step 5: Run Tests and Check Coverage Again

1. **Run tests:**
   ```bash
   mvn clean test jacoco:report
   ```

2. **Open the new report:**
   - Go to: `target/site/jacoco/index.html`
   - Check if coverage improved

3. **Repeat until 100% coverage:**
   - Identify remaining red lines
   - Add more tests
   - Re-run and check again

---

## Step 6: Update Coverage Requirement (Optional)

If you want to enforce 100% coverage:

1. **Open `pom.xml`**
2. **Find coverage limits** (around line 219)
3. **Change `0.80` to `1.0`** (4 places)
4. **Save and commit**

---

## Step 7: Use for Final Report

### Take Screenshots:
1. **Screenshot of summary table** (showing total coverage)
2. **Screenshot of a specific class** (showing detailed coverage)
3. **Screenshot before/after** (if you improved coverage)

### Include in Report:
- Coverage percentage achieved
- Screenshots of the report
- Explanation of test strategy
- Coverage improvement over time (if applicable)

---

## Quick Checklist

- [ ] Check total coverage percentage
- [ ] Identify classes with < 100% coverage
- [ ] Click on red/yellow classes to see details
- [ ] Note which lines/branches are missing
- [ ] Add tests for missing coverage
- [ ] Re-run tests and check again
- [ ] Take screenshots for final report
- [ ] Aim for 100% coverage (or at least 80%)

---

## Common Scenarios

### Scenario 1: Class has 0% coverage
**Problem**: No tests at all for this class
**Solution**: Create comprehensive tests for all methods

### Scenario 2: Class has 50% coverage
**Problem**: Some methods tested, some not
**Solution**: Add tests for untested methods

### Scenario 3: Method has red branches
**Problem**: If/else not fully tested
**Solution**: Add tests for both if and else cases

### Scenario 4: Constructor not tested
**Problem**: Constructor coverage missing
**Solution**: Add test that creates object instances

---

## Tips

1. **Start with critical classes:**
   - Focus on Huffman, B+, KMP, File Ops first (PDF requirement)

2. **Test edge cases:**
   - Empty inputs
   - Null values
   - Maximum values
   - Invalid inputs

3. **Test error conditions:**
   - What happens when things go wrong?
   - Exception handling
   - Boundary conditions

4. **Don't just aim for 100%:**
   - Make sure tests are meaningful
   - Test real scenarios
   - Test use cases mentioned in PDF

---

## Next Steps

1. **Analyze your current coverage**
2. **Identify the lowest coverage classes**
3. **Add tests for those classes**
4. **Re-run and check improvement**
5. **Repeat until satisfied (80% minimum, 100% ideal)**

Good luck! 🎯

