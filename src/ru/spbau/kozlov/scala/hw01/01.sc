def fib(n: Int, k: Int): BigInt = if (n <= 0) 0 else if (n <= k) 1 << (n - 1) else (0 until k).map(i => fib(n - 1 - i, k)).sum

(1 until 10).map(i => fib(i, 5))