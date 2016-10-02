####Yhteenlasku
- O(mn) m x n-matriiseilla

####Jälki
- O(n) n x n-matriisilla

####Skalaarilla kertominen
- O(mn) m x n-matriisilla

####Matriisitulo
- Naiivi algoritmi on O(mnp) m x n-matriisilla ja n x p-matriisilla, eli erityisesti O(n^3) n x n-matriiseilla
- Tiralabran aiemman version sivuilla luki että matriisien kertolaskua tulisi mielellään toteuttaa
 Strassenin algoritmilla eikä naiivilla algotmilla, joten pyrin siihen
- Strassenin algoritmi on noin O(n^2,81) n x n-matriiseilla missä n = 2^k jollakin k

####Transponointi
- O(mn) m x n-matriisilla

####Käänteismatriisi
- Toteutan Gaussin-Jordanin eliminointimenetelmällä, joka on O(n^3)

####Aste
- ehkä Gaussin eliminointimenetelmällä, joka on O(n^3), mutta voi olla epäluotettava liukulukuja käytettäessä
- ehkä "singular value decomposition" (pääakselihajotelma)
- ehkä "rank-revealing QR factorization"

####Determinantti
- Gaussin eliminointimenetelmä, joka on O(n^3)
