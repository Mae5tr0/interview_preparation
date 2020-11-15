def solution(t)
  n = t.length
  minimums = Array.new(n)
  maximums = Array.new(n)

  maximums[0] = t[0]
  minimums[n - 1] = t[n - 1]

  for i in 1.upto(n-1)
    if maximums[i - 1] < t[i]
      maximums[i] = t[i]
    else
      maximums[i] = maximums[i - 1]
    end
  end

  for i in (n-2).downto(0)
    if t[i] < minimums[i + 1]
      minimums[i] = t[i]
    else
      minimums[i] = minimums[i + 1]
    end
  end

  t.each_with_index do |measurement, i|
    if (i == 0 && measurement < minimums[i + 1]) ||
      (i == n - 1 && measurement > maximums[i - 1]) ||
      (i != 0 && i != n - 1 && measurement < minimums[i + 1] && measurement > maximums[i - 1])
      return i
    end
  end

  -1
end

puts solution([5, -2, 3, 8, 6]) # 3
# puts solution([-5, -5, -5, -42, 6, 12]) # 4