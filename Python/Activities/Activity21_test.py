import pytest

def test_addition():
    num1 = 5
    num2 = 3
    sum = num1 + num2
    assert sum==8

def test_subtraction():
    num1 = 5
    num2 = 3
    difference = num1 - num2
    assert difference == 2

def test_multiplication():
    num1 = 5
    num2 = 3
    product = num1 * num2
    assert product == 15

def test_division():
    num1 = 20
    num2 = 5
    div = num1 / num2
    assert div == 4