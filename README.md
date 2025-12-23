# AgeOfTheUniverse

Kotlinで実装された、宇宙の年齢を計算するシミュレーションプロジェクトです。
数値積分を用いて、ビッグバン（スケール因子 $a=0$）から現在（$a=1$）までの時間を算出します。

## 概要

このプロジェクトは、宇宙論パラメータと数値計算アルゴリズムを組み合わせ、異なる宇宙モデルにおける宇宙年齢を導き出します。
設計には **Strategyパターン** を採用しており、物理モデル（宇宙論）と数学的計算（数値積分）が疎結合になっています。これにより、新しい宇宙モデルや積分アルゴリズムを容易に追加・検証することが可能です。

## 特徴

*   **柔軟な設計**: 計算ロジック（`Calculator`）は特定のモデルやアルゴリズムに依存しません。
*   **物理モデルの切り替え**: 現代の標準モデルや、古典的なモデルを簡単に切り替えて計算できます。
*   **積分精度の比較**: 異なる数値積分手法を用いて、計算結果の差異を検証できます。

## ディレクトリ構成

```
AgeOfTheUniverse/
├── Calculator.kt             # 計算のオーケストレーター
├── Main.kt                   # 実行エントリーポイント
├── cosmology/                # 宇宙論モデル（Physics）
│   ├── CosmologyModelStrategy.kt
│   ├── LambdaCdmImpl.kt      # ΛCDMモデル（標準モデル）
│   └── MatterDominatedFlatImpl.kt # 物質優勢平坦モデル
└── integration/              # 数値積分アルゴリズム（Math）
    ├── IntegrateStrategy.kt
    ├── SimpsonImpl.kt        # シンプソン法
    └── TrapezoidalImpl.kt    # 台形公式
```

## サポートされている機能

### 宇宙論モデル (Cosmology Models)
1.  **LambdaCDM ($\Lambda$CDM)**: 暗黒物質（Dark Matter）と暗黒エネルギー（Dark Energy / Cosmological Constant）を考慮した、現代の標準的な宇宙モデル。
2.  **Matter Dominated Flat (Einstein-de Sitter)**: 宇宙定数がなく、物質のみで構成される平坦な宇宙モデル。理論値として $t_0 = \frac{2}{3}H_0^{-1}$ が知られています。

### 数値積分手法 (Integration Strategies)
1.  **Simpson's Rule (シンプソン法)**: 放物線近似を用いる手法。一般に高精度です。
2.  **Trapezoidal Rule (台形公式)**: 線形近似を用いる基本的な手法。

## 実行方法

`Main.kt` を実行してください。デフォルトでは以下のシナリオが実行されます。

1.  $\Lambda$CDMモデルによる年齢計算
2.  物質優勢モデルによる年齢計算と、理論値との比較
3.  $\Lambda$CDMモデルにおける、シンプソン法と台形公式の計算結果比較

### 出力例

```text
--- Age of the Universe Calculation ---

Model: LambdaCDM (Standard)
H0: 70.0 km/s/Mpc
Age: 13.47... Gyr

Model: Matter Dominated Flat (Einstein-de Sitter)
Age: 9.30... Gyr
Theoretical Age (2/3 * 1/H0): 9.30... Gyr
Difference: ... Gyr

--- Strategy Comparison (LambdaCDM) ---
Simpson Rule: 13.47... Gyr
Trapezoidal Rule: 13.46... Gyr
```

## ライセンス

このプロジェクトは学習および実験目的で作成されています。
