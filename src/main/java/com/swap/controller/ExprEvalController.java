package com.swap.controller;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.swap.ExprEvalServiceInterface;
import com.swap.forms.InputDataForm;

@Controller
public class ExprEvalController {
	
	@RequestMapping(value = "/inputPage")
	public ModelAndView inputPage(@ModelAttribute("inputDataForm") InputDataForm form) {
		
		form.setField1(null);
		form.setField2(null);
		return new ModelAndView("inputPage");
	}
	
	@RequestMapping(value = "/evaluateExpr")
	public ModelAndView evaluateExpr(@ModelAttribute("inputDataForm") InputDataForm form) {
		
		String inputExpr = form.getField1();
		
		if (inputExpr != null && inputExpr != "") {
			ExprEvalServiceInterface obj = str -> {
				char[] tokens = str.toCharArray();

				Stack<Integer> values = new Stack<Integer>();
				Stack<Character> operators = new Stack<Character>();

				for (int i = 0; i < tokens.length; i++) {
					if (tokens[i] == ' ') {
						continue;
					}
					if (tokens[i] >= '0' && tokens[i] <= '9') {
						StringBuffer sbuf = new StringBuffer();
						while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
							sbuf.append(tokens[i++]);
						}
						i--;
						values.push(Integer.parseInt(sbuf.toString()));
					} else if (tokens[i] == '(') {
						operators.push(tokens[i]);
					} else if (tokens[i] == ')') {
						while (operators.peek() != '(')
							values.push(performOperation(operators.pop(), values.pop(), values.pop()));
						operators.pop();
					} else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
						while (!operators.empty() && hasHighPriority(tokens[i], operators.peek())) {
							values.push(performOperation(operators.pop(), values.pop(), values.pop()));
						}
						operators.push(tokens[i]);
					}
				}

				while (!operators.empty()) {
					values.push(performOperation(operators.pop(), values.pop(), values.pop()));
				}

				return values.pop();

			};

			Integer result = obj.evaluate(inputExpr);
			form.setField2(result);
		}
		
		return new ModelAndView("outputPage");
	}

	public boolean hasHighPriority(char op1, char op2) {
		if (op2 == '(' || op2 == ')') {
			return false;
		} else if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
			return false;
		} else {
			return true;
		}
	}

	public int performOperation(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0){
				throw new UnsupportedOperationException("Cannot divide by zero");
			}
			return a / b;
		}
		return 0;
	}
	
}
