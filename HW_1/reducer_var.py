#!/usr/bin/env python3

import sys
m_m = 0
res_v = 0.0
c_m = 0.0

for line in sys.stdin:
  c_k, m_k, v_k = [float(el) for el in line.split()]   
  res_v = (res_v * c_m + v_k * c_k) / (c_m + c_k) + c_m * c_k * ((m_k - m_m)/(c_m + c_k)) ** 2
  m_m = (m_m * c_m + m_k * c_k) / (c_m + c_k)
  c_m += c_k

print('numpy.var ', '57674.242403', ' var ', res_v)
