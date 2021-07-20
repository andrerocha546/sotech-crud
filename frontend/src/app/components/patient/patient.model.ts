import { BaseEntity } from "./baseEntity.model";
import { Parents } from "./data/parents.model";

export interface Patient extends BaseEntity {
    id?: string,
    parents: Parents
}