# Language Proposal

Ada is designed to support large applications which "support strutured, object-oriented, generic, distributed and concurrent programming directly" (onecomplier.com). 

The definition can be found at http://ada-auth.org/standards/12rm/RM-Final.pdf

Our interpreter highlights the use of the of the code examples in this file. 

# Identifiers
"An identifier shall not contain two consecutive characters in category punctuation_connector, or end with a character in that category." 

      identifier ::= 
      identifier_letter { [ "_" ] ( identifier_letter | digit ) } 

# Keywords
The following are the reserved words. Within a program, some or all of the letters of a reserved word may be in upper case.

|  |  |  |  |
| ------ | ------ | ------ | ------ |
|  and  |  end  |  out  |  when  |
|  array  |  exit  |  procedure  |  with  |
|  begin  |  if  |  return  | function |
|  constant  |  is  |  then  | not |
|  declare  |  loop  |  type  | while  |
|  else  |  of  |  use  |  |
  

# Special Functions

Put_Line    - write to console

sqrt        - take the square root of a value or function

Float       - defines numeric floating point values

'Pred       - access element to the left of an index in and array

'Succ       - access element to the right of an index in an array

--          - comments

# Statements

### The BNF defintion of an if-else statement:
(http://ada-auth.org/standards/12rm/RM-Final.pdf)

      if_statement ::=
      if condition then
      sequence_of_statements
      {elsif condition then
      sequence_of_statements}
      [else
      sequence_of_statements]
      end if; 

### The BNF defintion of an loop_statement statement:
(http://cui.unige.ch/isi/bnf/Ada95/loop_statement.html)

      loop_statement ::= [ statement_identifier ":" ]

            [ ( "while" condition ) | ( "for" 
            defining_identifier "in" [ "reverse" ] discrete_subtype_definition ) ] 
            "loop" 
            sequence_of_statements 
            "end" "loop" [ statement_identifier ] ";" 

### The BNF defintion of an expression statement:
(https://cui.unige.ch/isi/bnf/Ada95/expression.html)

      expression ::= 
            relation { "and" relation } | relation { "and" "then" relation } 
            | relation { "or" relation } | relation { "or" "else" relation } 
            | relation { "xor" relation } 

### The BNF defintion of a statement:
(https://cui.unige.ch/isi/bnf/Ada95/statement.html)

      statement ::= { label } ( simple_statement | compound_statement ) 

### The BNF definition of a formal package declaration statement:
(https://cui.unige.ch/isi/bnf/Ada95/formal_package_declaration.html)

      formal_package_declaration ::= 
            "with" "package" defining_identifier "is" 
            "new" package_name formal_package_actual_part ";" 

### The BNF definition of an unconstrained array:
(https://cui.unige.ch/isi/bnf/Ada95/unconstrained_array_defini.html)

      unconstrained_array_definition ::= 
            "array" "(" index_subtype_definition 
            { "," index_subtype_definition } ")" "of" component_definition 

### The BNF definition of a subprogram body:
(https://cui.unige.ch/isi/bnf/Ada95/subprogram_body.html)

      subprogram_body ::= 
            subprogram_specification "is" 
            declarative_part 
            "begin" 
            handled_sequence_of_statements 
            "end" [ designator ] ";" 

### The BNF definition of a subprogram specification:
(https://cui.unige.ch/isi/bnf/Ada95/subprogram_specification.html)

      subprogram_specification ::= 
            ( "procedure" defining_program_unit_name [ formal_part ] ) 
            | ( "function" defining_designator [ formal_part ] "return" subtype_mark ) 


### The BNF definition of a function:
(https://cui.unige.ch/isi/bnf/Ada95/function_call.html)

      function_call ::= 
            ( function_name | prefix ) [ actual_parameter_part ] 


### The BNF definition of a return statement:
(https://cui.unige.ch/isi/bnf/Ada95/return_statement.html)

      return_statement ::= "return" [ expression ] ";" 

