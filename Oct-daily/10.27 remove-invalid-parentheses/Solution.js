var removeInvalidParentheses = function (s) {
  const res = [];
  const queue = [s];
  const set = new Set();
  while (true) {
    const len = queue.length;
    for (let i = 0; i < len; i++) {
      key = queue.shift();
      if (isValid(key)) {
        res.push(key);
      } else if (!res.length) {
        for (let j = 0; j < key.length; j++) {
          // Generate substring for justification
          if (key[j] === "(" || key[j] === ")") {
            const str = key.slice(0, j) + key.slice(j + 1);
            if (!set.has(str)) {
              queue.push(str);
              set.add(str);
            }
          }
        }
      }
    }
    if (res.length) {
      break;
    }
  }
  return res;
};

const isValid = (s) => {
  let count = 0;
  for (let i = 0; i < s.length; i++) {
    if (s[i] === "(") {
      count++;
    } else if (s[i] === ")") {
      count--;
    } // Left must more than right, or equal
    if (count < 0) {
      return false;
    }
  }
  return count === 0;
};
