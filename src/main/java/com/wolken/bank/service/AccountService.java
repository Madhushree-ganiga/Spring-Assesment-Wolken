package com.wolken.bank.service;

import com.wolken.bank.dto.AccountDTO;

public interface AccountService {

	String validateAndCreate(AccountDTO dto);

	double validateAndgetCurrentBalance(String holderName);

	AccountDTO validateAndFindByBranchName(String branchName);

	String validateAndDeposit(AccountDTO dto);

	String validateAndWithdraw(AccountDTO dto);

	String validateAccountStatus(AccountDTO dto);

}
