
import 'package:flutter/material.dart';
import 'package:show_case_flutter/home_screen.dart';
import 'package:showcaseview/showcaseview.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: ShowCaseWidget(builder: (context) => const HomeScreen()),
    );
  }
}
