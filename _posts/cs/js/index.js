var str = "abcdabcd";

console.log(str.charAt(2));

console.log(str.substr(2,2));
console.log(str.substring(2,4));

console.log(str.indexOf("c"));
console.log(str.indexOf("c",3));

var str2 = "a,b,c";
var arr = str2.split(",");
console.log(arr);

var arr2 = arr.concat("d");
console.log(arr2);

var arr3 = arr.concat(arr,arr2);
console.log(arr3);

