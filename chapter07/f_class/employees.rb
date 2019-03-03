#encoding: UTF-8
class Employee
  attr_reader :name, :basePay
  
  def initialize(name, basePay)
    @name = name
    @basePay = basePay
  end
    
  def calculatePay(taxRate)
    raise NotImplementedError
  end
  
  def monthlyBasePay()
    raise NotImplementedError
  end
end

class SalariedEmployee < Employee
  def initialize(name, basePay)
    super(name, basePay)
  end
    
  def calculatePay(taxRate)
    return basePay - (basePay * taxRate)
  end
  
  def monthlyBasePay()
    return basePay
  end
end

class HourlyEmployee < Employee
  attr_reader :timeCard
  def initialize(name, basePay, timeCard)
    super(name, basePay)
    @timeCard = timeCard
  end
  
  def calculatePay(taxRate)
    return (basePay * timeCard) - (basePay * timeCard) * taxRate
  end
  
  def monthlyBasePay()
    return 0
  end  
end

$employees = [
  SalariedEmployee.new("직원A", 400),
  SalariedEmployee.new("직원B", 300),
  SalariedEmployee.new("직원C", 250),
  HourlyEmployee.new("아르바이트D", 1, 120),
  HourlyEmployee.new("아르바이트E", 1, 120),
  HourlyEmployee.new("아르바이트F", 1, 120),
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