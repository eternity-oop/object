#encoding: UTF-8
module Employees
  $employees = ["직원A", "직원B", "직원C", "아르바이트D", "아르바이트E", "아르바이트F"]
  $basePays = [400, 300, 250, 1, 1, 1.5]
  $hourlys = [false, false, false, true, true, true]
  $timeCards = [0, 0, 0, 120, 120, 120]

  def Employees.calculatePay(name, taxRate)
    if (Employees.hourly?(name)) then
      pay = Employees.calculateHourlyPayFor(name, taxRate)
    else
      pay = Employees.calculatePayFor(name, taxRate)
    end
  end

  def Employees.hourly?(name)
    return $hourlys[$employees.index(name)]
  end

  def Employees.calculateHourlyPayFor(name, taxRate)
    index = $employees.index(name)
    basePay = $basePays[index] * $timeCards[index]
    return basePay - (basePay * taxRate)
  end

  def Employees.calculatePayFor(name, taxRate)
    return basePay - (basePay * taxRate)
  end
  
  def Employees.sumOfBasePays()
    result = 0
    for name in $employees
      if (not Employees.hourly?(name)) then
        result += $basePays[$employees.index(name)]
      end
    end
    return result
  end
end

def main(operation, args={})
  case(operation)
  when :pay then calculatePay(args[:name])
  when :basePays then sumOfBasePays()
  end
end

def calculatePay(name)
  taxRate = getTaxRate()
  pay = Employees.calculatePay(name, taxRate)
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
  puts(Employees.sumOfBasePays())
end

main(:basePays)
main(:pay, name:"아르바이트F")