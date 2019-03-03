#encoding: UTF-8
Employee = Struct.new(:name, :basePay, :hourly, :timeCard) do
  def calculatePay(taxRate)
    if (hourly) then
      return calculateHourlyPay(taxRate)
    end
    return calculateSalariedPay(taxRate)
  end

  def monthlyBasePay()
    if (hourly) then return 0 end
    return basePay
  end
  
private  
  def calculateHourlyPay(taxRate)
    return (basePay * timeCard) - (basePay * timeCard) * taxRate
  end
  
  def calculateSalariedPay(taxRate)
    return basePay - (basePay * taxRate)
  end
end

$employees = [
  Employee.new("직원A", 400, false, 0),
  Employee.new("직원B", 300, false, 0),
  Employee.new("직원C", 250, false, 0),
  Employee.new("아르바이트D", 1, true, 120),
  Employee.new("아르바이트E", 1, true, 120),
  Employee.new("아르바이트F", 1, true, 120),
]

def main(operation, args={})
  case(operation)
  when :pay then calculatePay(args[:name])
  when :basePays then sumOfBasePays()
  end
end

def calculatePay(name)
  taxRate = getTaxRate()
  for each in $employees
    if (each.name == name) then employee = each; break end
  end
  pay = employee.calculatePay(taxRate)
  puts(describeResult(name, pay))
end

def getTaxRate()
  print("세율을 입력하세요: ")
  return gets().chomp().to_f()
end

def describeResult(name, pay)
  return "이름 : #{name}, 급여 : #{pay}"
end

def sumOfBasePays()
  result = 0
  for each in $employees
    result += each.monthlyBasePay()
  end
  puts(result)
end

main(:basePays)
main(:pay, name:"아르바이트F")