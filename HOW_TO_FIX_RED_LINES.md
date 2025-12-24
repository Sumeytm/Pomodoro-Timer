# How to Fix Red Lines in Coverage Report

If you see many red lines, it means those parts of your code are not tested. Here's how to fix it.

---

## Step 1: Identify Which Classes Have Red Lines

1. **In the coverage report**, scroll down to see the class list
2. **Look for classes with red/yellow colors** (low coverage)
3. **Click on a class name** to see which lines are red

### Priority Order:
1. **Critical algorithms first** (PDF requirement):
   - HuffmanCoding
   - BPlusTree
   - KMPAlgorithm
   - FileOperations

2. **Then other classes** with low coverage

---

## Step 2: Analyze Red Lines in Each Class

When you click on a class:

1. **See the code with colors:**
   - 🟢 Green lines = Tested (good!)
   - 🔴 Red lines = Not tested (need tests!)

2. **Identify what's missing:**
   - Which methods have red lines?
   - Which if/else branches are red?
   - Which error cases aren't tested?

### Example:
```
Line 45: public void addFirst(T data) {  // RED - not tested
Line 46:     Node<T> newNode = ...       // RED - not tested
Line 47:     if (head == null) {         // RED - not tested
```

This means the `addFirst` method needs tests!

---

## Step 3: Add Tests for Red Lines

### For Each Red Method:

1. **Open the test file:**
   - Example: `DoubleLinkedList.java` → `DoubleLinkedListTest.java`

2. **Add a test method:**
   ```java
   @Test
   public void testAddFirst() {
       DoubleLinkedList<String> list = new DoubleLinkedList<>();
       list.addFirst("test");
       assertEquals(1, list.size());
       assertEquals("test", list.getFirst());
   }
   ```

3. **Test all scenarios:**
   - Normal case
   - Edge case (empty list, single element)
   - Error case (if applicable)

### For Red Branches (if/else):

If you see red in if/else statements:

```java
// Original code (line 47-50):
if (head == null) {        // GREEN (tested)
    head = tail = newNode;
} else {                   // RED (not tested!)
    newNode.next = head;
}
```

**Add test for the else branch:**
```java
@Test
public void testAddFirstWhenListNotEmpty() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addFirst("first");
    list.addFirst("second");  // This tests the else branch
    assertEquals(2, list.size());
    assertEquals("second", list.getFirst());
}
```

---

## Step 4: Common Red Line Scenarios

### Scenario 1: Constructor Not Tested
**Red lines**: Constructor code
**Solution**: 
```java
@Test
public void testConstructor() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
}
```

### Scenario 2: Getter Methods Not Tested
**Red lines**: Getter methods
**Solution**:
```java
@Test
public void testGetFirst() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addFirst("test");
    assertEquals("test", list.getFirst());
}
```

### Scenario 3: Error Handling Not Tested
**Red lines**: Exception throwing code
**Solution**:
```java
@Test
public void testRemoveFirstOnEmptyList() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    assertThrows(NoSuchElementException.class, () -> {
        list.removeFirst();
    });
}
```

### Scenario 4: Edge Cases Not Tested
**Red lines**: Special conditions
**Solution**:
```java
@Test
public void testAddToEmptyList() {
    // Test when list is empty
}

@Test
public void testAddToSingleElementList() {
    // Test when list has one element
}
```

---

## Step 5: Systematic Approach

### Method 1: Class by Class

1. **Pick one class** (start with critical ones)
2. **Click on it** in coverage report
3. **List all red methods**
4. **Add tests for each red method**
5. **Move to next class**

### Method 2: Method by Method

1. **Find a class with red lines**
2. **Pick one red method**
3. **Write test for that method**
4. **Run test** to verify it works
5. **Check coverage** - should see green now
6. **Repeat for next method**

---

## Step 6: Run Tests and Check Coverage

After adding tests:

1. **Run tests:**
   ```bash
   cd C:\Users\pc\Pomodoro-Timer\pomodorotimertimertimer-app
   mvn clean test jacoco:report
   ```

2. **Open new report:**
   - Go to: `target\site\jacoco\index.html`
   - Check if red lines turned green

3. **Compare:**
   - Before: How many red lines?
   - After: How many red lines?
   - Improvement: Coverage percentage increased?

---

## Step 7: Repeat Until Coverage is Good

1. **Check coverage percentage:**
   - If < 80%: Keep adding tests
   - If 80-100%: Good! But aim for 100%
   - If 100%: Perfect! ✅

2. **Focus on remaining red lines:**
   - Identify what's still red
   - Add more tests
   - Re-run and check

---

## Quick Tips

### Tip 1: Test All Public Methods
- Every public method should have at least one test
- Test normal case + edge cases

### Tip 2: Test All Branches
- If you have `if/else`, test both branches
- If you have `switch`, test all cases

### Tip 3: Test Edge Cases
- Empty collections
- Single element
- Null values (if applicable)
- Maximum values
- Invalid inputs

### Tip 4: Test Error Conditions
- What happens when things go wrong?
- Exception handling
- Boundary conditions

---

## Example: Fixing DoubleLinkedList

### Current Situation:
- `addFirst()` method: RED
- `addLast()` method: RED
- `removeFirst()` method: RED
- Constructor: RED

### Solution: Add Tests

```java
@Test
public void testConstructor() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    assertTrue(list.isEmpty());
}

@Test
public void testAddFirst() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addFirst("test");
    assertEquals(1, list.size());
    assertEquals("test", list.getFirst());
}

@Test
public void testAddLast() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addLast("test");
    assertEquals(1, list.size());
    assertEquals("test", list.getLast());
}

@Test
public void testRemoveFirst() {
    DoubleLinkedList<String> list = new DoubleLinkedList<>();
    list.addFirst("test");
    String removed = list.removeFirst();
    assertEquals("test", removed);
    assertTrue(list.isEmpty());
}
```

After adding these tests, those methods should turn GREEN! ✅

---

## Priority Checklist

Start with these in order:

1. [ ] **HuffmanCoding** - Critical algorithm
2. [ ] **BPlusTree** - Critical algorithm
3. [ ] **KMPAlgorithm** - Critical algorithm
4. [ ] **FileOperations** - Critical algorithm
5. [ ] Other classes with < 50% coverage
6. [ ] Other classes with 50-80% coverage
7. [ ] Classes with 80-100% (aim for 100%)

---

## Don't Panic!

- **Many red lines is normal** at the beginning
- **Add tests gradually** - don't try to fix everything at once
- **Start with one class** - get it to 100%, then move to next
- **Focus on critical algorithms first** (PDF requirement)

---

## Next Steps

1. **Pick one class** with red lines
2. **Click on it** in coverage report
3. **Identify red methods**
4. **Add tests** for those methods
5. **Run tests** and check coverage
6. **Repeat** until coverage improves

Good luck! You can do it! 💪

