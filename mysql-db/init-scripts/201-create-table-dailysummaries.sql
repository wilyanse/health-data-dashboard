use health_db;

CREATE TABLE IF NOT EXISTS dailysummaries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    energy_kcal DECIMAL(10, 2),
    alcohol_g DECIMAL(10, 2),
    caffeine_mg DECIMAL(10, 2),
    water_g DECIMAL(10, 2),
    b1_thiamine_mg DECIMAL(10, 2),
    b2_riboflavin_mg DECIMAL(10, 2),
    b3_niacin_mg DECIMAL(10, 2),
    b5_pantothenic_acid_mg DECIMAL(10, 2),
    b6_pyridoxine_mg DECIMAL(10, 2),
    b12_cobalamin_ug DECIMAL(10, 2),
    folate_ug DECIMAL(10, 2),
    vitamin_a_ug DECIMAL(10, 2),
    vitamin_c_mg DECIMAL(10, 2),
    vitamin_d_iu DECIMAL(10, 2),
    vitamin_e_mg DECIMAL(10, 2),
    vitamin_k_ug DECIMAL(10, 2),
    calcium_mg DECIMAL(10, 2),
    copper_mg DECIMAL(10, 2),
    iron_mg DECIMAL(10, 2),
    magnesium_mg DECIMAL(10, 2),
    manganese_mg DECIMAL(10, 2),
    phosphorus_mg DECIMAL(10, 2),
    potassium_mg DECIMAL(10, 2),
    selenium_ug DECIMAL(10, 2),
    sodium_mg DECIMAL(10, 2),
    zinc_mg DECIMAL(10, 2),
    carbs_g DECIMAL(10, 2),
    fiber_g DECIMAL(10, 2),
    starch_g DECIMAL(10, 2),
    sugars_g DECIMAL(10, 2),
    added_sugars_g DECIMAL(10, 2),
    net_carbs_g DECIMAL(10, 2),
    fat_g DECIMAL(10, 2),
    cholesterol_mg DECIMAL(10, 2),
    monounsaturated_g DECIMAL(10, 2),
    polyunsaturated_g DECIMAL(10, 2),
    saturated_g DECIMAL(10, 2),
    trans_fats_g DECIMAL(10, 2),
    omega_3_g DECIMAL(10, 2),
    omega_6_g DECIMAL(10, 2),
    cystine_g DECIMAL(10, 2),
    histidine_g DECIMAL(10, 2),
    isoleucine_g DECIMAL(10, 2),
    leucine_g DECIMAL(10, 2),
    lysine_g DECIMAL(10, 2),
    methionine_g DECIMAL(10, 2),
    phenylalanine_g DECIMAL(10, 2),
    protein_g DECIMAL(10, 2),
    threonine_g DECIMAL(10, 2),
    tryptophan_g DECIMAL(10, 2),
    tyrosine_g DECIMAL(10, 2),
    valine_g DECIMAL(10, 2),
    completed BOOLEAN
);