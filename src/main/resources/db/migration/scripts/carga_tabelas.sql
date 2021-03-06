COPY estado(cod_estado, nome, sigla) FROM '/Users/Public/Documents/estados.csv' USING DELIMITERS';' with (format csv, header true)
COPY cidade (cod_cidade, cod_estado, nome) FROM '/Users/Public/Documents/cidades.csv' USING DELIMITERS';' with (format csv, header true)
COPY combustivel (cod_combustivel, nome) FROM '/Users/Public/Documents/combustiveis.csv' USING DELIMITERS';' with (format csv, header true)
COPY cor_veiculo (cod_cor, nome) FROM '/Users/Public/Documents/cores_veiculos.csv' USING DELIMITERS';' with (format csv, header true)
COPY marca_veiculo (cod_marca, descricao) FROM '/Users/Public/Documents/marca_veiculos.csv' USING DELIMITERS';' with (format csv, header true)
COPY modelo_veiculo (cod_modelo, cod_marca, cod_combustivel, ano, descricao) FROM '/Users/Public/Documents/modelo_veiculos.csv' USING DELIMITERS';' with (format csv, header true)