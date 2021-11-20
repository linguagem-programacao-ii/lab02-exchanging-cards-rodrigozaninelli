arquivo = open('C:\TEMP\cards.txt','r')

linha = arquivo.readline()

n = 1
nCardsBetty = 0
nCardsAlice = 0
dCardsAlice = {}
dCardsBetty = {}
while linha != '0 0':
    linha = linha.rstrip('\n')

    #le a quantidade de cartas de Alice e de Betty e as atribui a uma variavel (não foi utilizado esse valor no programa)
    if(n == 1):
        qtdCards = linha.split(" ")
        nCardsAlice = qtdCards[0]
        nCardsBetty = qtdCards[1]

    #le as cartas da Alice e as atribui com um dicionário onde a chave é a carta e o valor é a quantidade delas
    if(n == 2):
        cardsAlice = linha.split(" ")
        for cards in cardsAlice:
            dCardsAlice[cards] = cardsAlice.count(cards)

    #le as cartas da Betty e as atribui com um dicionário onde a chave é a carta e o valor é a quantidade delas
    if(n == 3):
        cardsBetty = linha.split(" ")
        for cards in cardsBetty:
            dCardsBetty[cards] = cardsBetty.count(cards)

        #para cada carta repetida de Alice é checado se Betty já possui a carta, e vice versa
        aliceTrades = 0
        bettyTrades = 0
        for cards in dCardsAlice:
            if (dCardsAlice[cards] > 1) and (cards not in dCardsBetty):
                aliceTrades += 1
        for cards in dCardsBetty:
            if(dCardsBetty[cards] > 1) and (cards not in dCardsAlice):
                bettyTrades +=1

        #compara qual das duas tem a menor quantidade de cartas repetidas que a outra não tem e imprime este valor x 2 (uma vez que alice da uma carta para betty e betty da uma carta para alice)
        if (aliceTrades >= bettyTrades):
            print(bettyTrades*2)
        else:
            print(aliceTrades*2)

        #reinicia os parametros para a nova leitura de trocas possíveis
        n = 0
        nCardsBetty = 0
        nCardsAlice = 0
        dCardsAlice = {}
        dCardsBetty = {}
        
    #segue para nova linha
    n +=1
    linha = arquivo.readline()