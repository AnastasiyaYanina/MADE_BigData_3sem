#!/usr/bin/env python3

import sys

MEAN = 152.719869
c_k = 0.0
m_k = 0.0
v_k = 0.0

for line in sys.stdin:
  m_k += float(line)
  v_k += (float(line) - MEAN) ** 2
  c_k += 1

print(c_k, '\t', m_k/c_k, '\t', v_k/c_k)
