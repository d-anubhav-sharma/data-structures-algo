class Complex:
    x=0
    y=0
    mod=0

    def __str__(self) -> str:
        return "({},{})".format(self.x, self.y)

    def __init__(self, x, y, mod):
        self.x = x
        self.y = y
        self.mod = mod
    
    def copy(self):
        return Complex(self.x,self.y,self.mod)
    
    def mul(self, other):
        a = self.x*other.x-self.y*other.y
        b = self.x*other.y+self.y*other.x
        self.x = a%self.mod
        self.y = b%self.mod

    def square(self):
        a = self.x*self.x-self.y*self.y
        b = self.x*self.y+self.y*self.x
        self.x = a%self.mod
        self.y = b%self.mod

def pow(complex_k: Complex, exp: int):
    result = Complex(1,0,complex_k.mod)
    base = complex_k.copy()
    while exp>0:
        if exp%2==1:
            result.mul(base)
        base.square()
        exp //=2
    return result

print(pow(Complex(2,2,1000),2))