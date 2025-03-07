import pytest

@pytest.mark.activity
@pytest.mark.parametrize("earned, spent, expected", [ (30, 10, 20), (20, 2, 18), ])
def test_transactions(wallet_amount, earned, spent, expected):
	
    print("wallet amount:", wallet_amount)
    # Add money to your wallet
    wallet_amount += earned
    print("wallet amount, after earning:", wallet_amount)

    # Subtract amount from wallet
    wallet_amount -= spent
    print("wallet amount, after spending:", wallet_amount)

    # Assertion
    assert wallet_amount == expected