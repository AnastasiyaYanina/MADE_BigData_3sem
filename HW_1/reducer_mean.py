#!/usr/bin/env python3
import sys

res_m = 0.0
c_m = 0.0

for line in sys.stdin:
  c_k, s_k = [float(el) for el in line.split()]
  res_m = (res_m * c_m + s_k * int(c_k)) / (c_m + c_k)
  c_m += c_k

print('numpy.mean ', 152.719869, ' mean ', res_m)
