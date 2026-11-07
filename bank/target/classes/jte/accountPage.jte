@param String title
@param edu.cwi.UserAccount account

@template.jte.accountLayout(
    title = title,
    account = @`@template.jte.userAccount(
        account.name(),
        account.formatBalance()
    )`,
    detail = @`@template.jte.transactionsList(
        account.transactions()
    )`
)