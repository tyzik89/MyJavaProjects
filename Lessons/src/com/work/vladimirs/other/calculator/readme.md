# Algorithm to convert infix to postfix expression

In this case, We use the stacks to convert infix to postfix. We have operator's stack, output's stack and one input string. Operator's stack works as FILO(First In Last Out). Output's stack works as FIFO (First In First Out).

The following algorithm converts infix to postfix.

1. Scan input string from left to right character by character.
2. If the character is an operand, put it into output stack.
3. If the character is an operator and operator's stack is empty, push operator into operators' stack.
4. If the operator's stack is not empty, there may be following possibilites.
   1. If the precedence of scanned operator is greater than the top most operator of operator's stack, push this operator into operand's stack.
   2. If the precedence of scanned operator is less than or equal to the top most operator of operator's stack, pop the operators from operand's stack until we find a low precedence operator than the scanned character. Never pop out ( '(' ) or ( ')' ) whatever may be the precedence level of scanned character.
   3. If the character is opening round bracket ( '(' ), push it into operator's stack.
   4. If the character is closing round bracket ( ')' ), pop out operators from operator's stack untill we find an opening bracket ('(' ).
   5. Now pop out all the remaining operators from the operator's stack and push into output stack.

# Algorithm to convert infix to prefix expression

In this case, we have operator's stack, output's stack and one input string. Operator's stack works as FILO(First In Last Out). Output's stack works as FIFO (First In First Out).

The following algorithm must be followed for infix to prefix conversion.

1. Reverse the input string.
2. Convert the reversed string into infix expression.
3. Now reverse the resulting infix expression obtained from the previous step. The resulting expression is prefix expression
