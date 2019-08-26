

## Sorted Insert Position

```java
Take two Integer start = 0 and End = n - 1;
Find the mid Element using 
    mid = (start + End) / 2;

if nums[mid] == target:
    return mid;

elif nums[mid] < target:

    if mid + 1 < n:
       nextElement = nums[mid+1];
       if target < nextElement:
          ans = mid + 1;
          break;
       else:
          start = mid + 1;
    else:
        ans = end + 1;
        break;

elif nums[mid] > target:

    if mid - 1 >= 0:
        prevElement = nums[mid - 1];
        if prevElement < target:
           ans = mid;
           break;
        else:
           end = mid - 1;
    else:
        ans = 0;
        break;


return ans;
```

