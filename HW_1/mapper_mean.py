#!/usr/bin/env python3

import sys

c_k = 0
m_k = 0

for line in sys.stdin:
  m_k += float(line)
  c_k += 1

print('%s\t%s' % (c_k, m_k/c_k))

