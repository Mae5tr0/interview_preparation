DUPLICATE_COMMAND = 'DUP'
SUBTRACTION_COMMAND = '-'
ADDITION_COMMAND = '+'
POP_COMMAND = 'POP'
UNSIGNED_INTEGER_LIMIT = 1048575
InvalidOperation = Class.new(StandardError)

# what size of stack should be?
def solution(s)
  stack = []
  s.split(' ').each do |input|
    case input
    when POP_COMMAND
      entry = stack.pop()
      raise InvalidOperation, 'Empty Stack' if entry == nil
    when DUPLICATE_COMMAND
      entry = stack.pop()
      raise InvalidOperation, 'Empty Stack' if entry == nil
      stack.push(entry)
      stack.push(entry)
    when ADDITION_COMMAND
      first = stack.pop()
      second = stack.pop()
      raise InvalidOperation, 'Empty Stack' if first == nil || second == nil
      raise InvalidOperation, 'Overflow Integer' if (first > UNSIGNED_INTEGER_LIMIT - second)
      stack.push(first + second)
    when SUBTRACTION_COMMAND
      first = stack.pop()
      second = stack.pop()
      raise InvalidOperation, 'Empty Stack' if first == nil || second == nil
      raise InvalidOperation, 'Negative value' if (first < second)
      stack.push(first - second)
    else
      stack.push(Integer(input))
    end
  end

  raise InvalidOperation, 'Empty Stack' if stack.length == 0
  stack.pop()
end

puts solution("13 DUP 4 POP 5 DUP + DUP + -")  # 7
puts solution("5 6 + -")  # 7
puts solution("3 DUP 5 - -")  # 7



