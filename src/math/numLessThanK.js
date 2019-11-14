
function balling(digitArr, digits, num) {
    if(digits > num) {
        return 0;
    } else if(digits < getLengthOfNum(num)) {
        return factorial(digitArr.length) / factorial(digitArr.length - digits);
    } else {
       return 0;
    }
}


function firstIDigits(num, i) {
    let str = num + '';
    str = str.slice(0, i);
    console.log(str);
    return +str;
}

function lowerElements(A, i) {
    return A.sort((a, b) => a - b)
            .filter(ele => ele < i).length;
}

function getLengthOfNum(num) {
    return ('' + num).length;
}


function factorial(num) {
    let ans = 1;
    for(let i=1; i<=num; i++) {
        ans *= i;
    }
    return ans;
}

console.log(lowerElements([1, 2, 4, 5], 4));
