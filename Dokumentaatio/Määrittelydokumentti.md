####Yhteenlasku
- O(mn) m x n-matriiseilla

####J‰lki
- O(n) n x n-matriisilla

####Skalaarilla kertominen
- O(mn) m x n-matriisilla

####Matriisitulo
- Naiivi algoritmi on O(mnp) m x n-matriisilla ja n x p-matriisilla, eli erityisesti O(n^3) n x n-matriiseilla
- Tiralabran aiemman version sivuilla luki ett‰ matriisien kertolaskua tulisi mielell‰‰n toteuttaa
 Strassenin algoritmilla eik‰ naiivilla algotmilla, joten pyrin siihen
- Strassenin algoritmi on noin O(n^2,81) n x n-matriiseilla miss‰ n = 2^k jollakin k

####Transponointi
- O(mn) m x n-matriisilla

####K‰‰nteismatriisi
- Toteutan Gaussin-Jordanin eliminointimenetelm‰ll‰, joka on O(n^3)

####Aste
- ehk‰ Gaussin eliminointimenetelm‰ll‰, joka on O(n^3), mutta voi olla ep‰luotettava kun k‰ytett‰ess‰
 liukulukuja
- ehk‰ "singular value decomposition" (p‰‰akselihajotelma)
- ehk‰ "rank-revealing QR factorization"

####Determinantti
- Gaussin eliminointimenetelm‰, joka on O(n^3)