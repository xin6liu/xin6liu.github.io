import numpy as np

with open('test.txt', 'w') as f:
    x = np.random.randint(51, size=1000)
    for i in range(2):
        np.savetxt(f,np.histogram(x, bins=30)[i].reshape(1,-1))
        f.write("\n")