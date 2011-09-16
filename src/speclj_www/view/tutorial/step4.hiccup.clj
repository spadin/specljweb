[:h3 [:a {:name "ch4"} "Splitting Test Code From Production Code"]]
[:p "You may have noticed that in <a href=\"/tutorial/step3#f5\">Figure 5</a>, the code we are testing is in the test file itself. This is not a good convention to follow because we want a clear separation between production code and test code so that the reader can easily follow what is going on. So let's see what happens when we move our equals-5? method into the core.clj file. <a href=\"#f6\">Figure 6</a> shows us the updated core.clj file."]

[:h5 [:a {:name "f6"} "Figure 6"]]
[:p "<pre class=\"textmate-source twilight\"><span class=\"source source_clojure\"><span class=\"meta meta_function meta_function_namespace meta_function_namespace_clojure\">(<span class=\"support support_function support_function_namespace support_function_namespace_clojure\">ns</span> <span class=\"entity entity_name entity_name_namespace entity_name_namespace_clojure\"><span class=\"source source_symbol source_symbol_clojure\">change_counter</span><span class=\"keyword keyword_operator keyword_operator_classpath keyword_operator_classpath_clojure\">.</span><span class=\"source source_symbol source_symbol_clojure\">core</span></span>)</span>

<span class=\"meta meta_function meta_function_clojure\">(<span class=\"storage storage_type storage_type_function storage_type_function_type storage_type_function_type_clojure\">defn</span> <span class=\"entity entity_name entity_name_function entity_name_function_clojure\"><span class=\"source source_symbol source_symbol_clojure\">equals-5<span class=\"keyword keyword_other keyword_other_mark keyword_other_mark_clojure\">?</span></span></span> <span class=\"meta meta_function meta_function_body meta_function_body_clojure\"><span class=\"meta meta_function meta_function_parameters meta_function_parameters_vector meta_function_parameters_vector_clojure\"><span class=\"punctuation punctuation_definition punctuation_definition_vector punctuation_definition_vector_begin punctuation_definition_vector_begin_clojure\">[</span><span class=\"variable variable_parameter variable_parameter_clojure\"><span class=\"source source_symbol source_symbol_clojure\">n</span></span><span class=\"punctuation punctuation_definition punctuation_definition_vector punctuation_definition_vector_end punctuation_definition_vector_end_clojure\">]</span></span><span class=\"meta meta_function meta_function_body meta_function_body_code meta_function_body_code_clojure\">
  <span class=\"meta meta_sexpr meta_sexpr_clojure\">(<span class=\"keyword keyword_operator keyword_operator_clojure\">=</span> <span class=\"constant constant_numeric constant_numeric_float constant_numeric_float_clojure\">5</span> <span class=\"source source_symbol source_symbol_clojure\">n</span>)</span></span></span>)</span></span></pre>"]

[:p "If we run the tests we get the following error:"]

[:code "java.lang.Exception: Unable to resolve symbol: equals-5? in this context"]


[:p "Basically this tells us that the core_spec.clj file doesn't know where the equals-5? method is anymore. Just like we had to explicitly tell our spec file to get methods from the speclj.core namespace, we have to tell our spec file to get methods from the change_counter.core namespace. To do this, we have to update the change_counter.core-spec namespace declaration as follows:"]

[:p "<pre class=\"textmate-source twilight\"><span class=\"source source_clojure\"><span class=\"meta meta_function meta_function_namespace meta_function_namespace_clojure\">(<span class=\"support support_function support_function_namespace support_function_namespace_clojure\">ns</span> <span class=\"entity entity_name entity_name_namespace entity_name_namespace_clojure\"><span class=\"source source_symbol source_symbol_clojure\">yibble</span><span class=\"keyword keyword_operator keyword_operator_classpath keyword_operator_classpath_clojure\">.</span><span class=\"source source_symbol source_symbol_clojure\">core-spec</span></span>
  (<span class=\"support support_other support_other_keyword support_other_keyword_namespace support_other_keyword_namespace_clojure\">:use</span> [<span class=\"source source_symbol source_symbol_clojure\">speclj</span><span class=\"keyword keyword_operator keyword_operator_classpath keyword_operator_classpath_clojure\">.</span><span class=\"source source_symbol source_symbol_clojure\">core</span>] [<span class=\"source source_symbol source_symbol_clojure\">yibble</span><span class=\"keyword keyword_operator keyword_operator_classpath keyword_operator_classpath_clojure\">.</span><span class=\"source source_symbol source_symbol_clojure\">core</span>]))</span></span></pre>"]


[:p "If we run our tests again, the spec file will know where the equals-5? method is and the tests will pass again."]

[:h3 [:a {:name "ch5"} "Running Multiple Test Files"]]
[:p "If we have a project that has many files, we will want to have many test files that each focus on a specific aspect of functionality. Speclj makes this easy. Every file in the spec directory automatically gets evaluated when we run our tests. The convention is to add _spec to the end of the file name to let readers know that it is a spec file."]
[:span {:id "lesson_nav"} [:a {:href "/tutorial/step3"} "<-- The Basics"] "&nbsp;&nbsp;|&nbsp;&nbsp;" [:a {:href "/tutorial/step5"} "Testing Input and Output -->"]]