#encoding: UTF-8
$employees = ["직원A", "직원B", "직원C"]
$basePays = [400, 300, 250]

def main(operation, args={})
  case(operation)
  when :pay then calculatePay(args[:name])
  when :basePays then sumOfBasePays()
  end
end

def calculatePay(name)
  taxRate = getTaxRate()
  pay = calculatePayFor(name, taxRate)
  puts(describeResult(name, pay))
end

def getTaxRate()
  print("세율을 입력하세요: ")
  return gets().chomp().to_f()
end

def calculatePayFor(name, taxRate)
  index = $employees.index(name)
  basePay = $basePays[index]  
  return basePay - (basePay * taxRate)
end

def describeResult(name, pay)
  return "이름 : #{name}, 급여 : #{pay}"
end

def sumOfBasePays()
  result = 0
  for basePay in $basePays
    result += basePay
  end  
  puts(result)
end

main(:basePays)
main(:pay, name:"직원A")