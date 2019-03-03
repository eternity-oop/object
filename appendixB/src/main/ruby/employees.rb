#encoding: UTF-8
class SalariedEmployee
  def initialize(name, basePay)
    @name = name
    @basePay = basePay
  end
    
  def calculatePay(taxRate)
    @basePay - (@basePay * taxRate)
  end
end

class HourlyEmployee < Employee
  def initialize(name, basePay, timeCard)
    @name = name
    @basePay = basePay
    @timeCard = timeCard
  end
  
  def calculatePay(taxRate)
    (@basePay * @timeCard) - (@basePay * @timeCard) * taxRate
  end
end

def calculate(employee, taxRate)
  employee.calculatePay(taxRate)
end
